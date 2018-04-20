# SB Middleman...
...is the server-side code for my project "SB Notifier" (an Android app). At some point, there should be a
repository with that name on my GitHub profile.

## The whole point of this project is the App.
This server is mainly there to provide a more lightweight API to UOL's bulletin board, since to
its users it only provides a Web interface costing a lot of data (about 70 to 90 kB each
time the website is fetched).

This server provides a lightweight REST API that sends the bulletin board's (meta) data via the JSON format.
Also, various parameters can be put into the (HTTP) requests, thus further increasing the efficiency and accuracy of
the server.
