package net;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.CharBuffer;

/**
 * The class contains the runnable code of the individual threads
 * with each client. Every connection the net.Server class has made
 * gets passed onto a new thread running this class as its Runnable.
 * That is why the constructor takes in the appropriate java.net.Socket
 * object.
 *
 * NetWorker's tasks are in order:
 *      1. Read and parse incoming HTTP request
 *      2. Match request to appropriate API call (with parameters)
 *      3. Query database for appropriate content
 *      4. Construct JSON response and send
 *      5. Cleanup.
 */
public class NetWorker implements Runnable {
    private Socket connection;

    /**
     * Constructor. Takes in the java.net.Socket object that was created
     * under the the connection to a new client. Prepares the class's attributes
     * for the new thread.
     * @param connection
     */
    NetWorker(Socket connection) {
        this.connection = connection;
    }

    /**
     * The actual code running after Thread#start() has been called.
     */
    public void run() {
        String request = readHTTPRequest();
    }

    /**
     * Vanilla Java! lel
     *
     * Reads the client's HTTP request from the socket's input stream
     * via a DataInputStream and converts the raw bytes into a String
     *
     *
     *
     * @return The client's HTTP request as String
     */
    private String readHTTPRequest() {
        int input;
        DataInputStream in;
        StringBuilder buffer = new StringBuilder();
        try {
            in = new DataInputStream(connection.getInputStream());

            while ((input = in.read()) != -1) {
                System.out.print((char) input);

                // End of headers
                if (input == '\r' && (input = in.read()) == '\n' &&
                        (input = in.read()) == '\r' && (input = in.read()) == '\n') {
                    break;
                }

                buffer.append((char) input);
            }
            return buffer.toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return buffer.toString();
    }
}
