package org.fun;

import static java.util.Objects.nonNull;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Takes a list of URLs from the specified file and returns the shortened version of them.
 */
public class TrimmerLinkerTaylorSpy {

    private final static String IS_GD_ENDPOINT = "https://is.gd/create.php?format=simple";
    private final static HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        if (nonNull(args) && args.length > 0) {
            getInputUrls(args[0])
                    .forEach(TrimmerLinkerTaylorSpy::outputShortenedUrl);
        } else {
            System.out.println(
                    "There was a problem with the supplied arguments. Proper usage is: java ShortenUrl <file_with_urls>");
        }
    }

    /**
     * Returns a list of URLs from file specified by the filename provided.
     *
     * @param filename Filename for input URL data.
     * @return List of URL strings.
     */
    private static Collection<String> getInputUrls(String filename) {
        Collection<String> result = Collections.emptySet();
        try {
            result = Files.readAllLines(Paths.get(filename)).stream().filter(Objects::nonNull)
                    .filter(s -> !s.trim().isEmpty()).collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("There was a failure trying to reading file: " + filename);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Output URL shortening result.
     *
     * @param url URL to shorten
     */
    private static void outputShortenedUrl(String url) {
        if (nonNull(url) && !url.trim().isEmpty()) {
            try {
                HttpResponse<String> httpResponse = httpClient.send(generateRequest(url),
                        HttpResponse.BodyHandlers.ofString());
                if (httpResponse.statusCode() == 200) {
                    System.out.println(httpResponse.body() + ", " + url);
                } else {
                    System.out.println(
                            "There was an error during URL shortening. Status code: " + httpResponse.statusCode()
                                    + " Message: " + httpResponse.body());
                }
            } catch (IOException | InterruptedException e) {
                System.out.println(
                        "There was a failure communicating with the is.gd site. The URL that failed to shorten was: "
                                + url);
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a HttpRequest for shortening the supplied URL data.
     *
     * @param url URL to shorten
     * @return HttpResponse
     */
    private static HttpRequest generateRequest(String url) {
        return HttpRequest.newBuilder().uri(URI.create(IS_GD_ENDPOINT))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("url=" + URLEncoder.encode(url, StandardCharsets.UTF_8)))
                .build();
    }

}
