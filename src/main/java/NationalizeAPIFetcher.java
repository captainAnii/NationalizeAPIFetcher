import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NationalizeAPIFetcher {

    public static void main(String[] args) {
        String apiUrl = "https://api.nationalize.io/?name=nathaniel";

        try {
            // Create URL object
            URL url = new URL(apiUrl);
            // Create HttpURLConnection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Print response
                System.out.println("API Response:");
                System.out.println(response.toString());
            } else {
                System.out.println("API request failed. Response Code: " + responseCode);
            }

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


