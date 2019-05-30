# gitHubApi
A GitHub API to pull a GitHub users current followers.

Must know the exact spelling of the user.  Will only show the JSON return if it is your GitHub ID and you are signed in.

Also, uses the updated Mozilla - 67.0.


Requires the following imports for Eclipse:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
