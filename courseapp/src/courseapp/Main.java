package courseapp;

import coursedatabase.Course;
import coursedatabase.CourseServer;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CourseServer courseServer = new CourseServer();
        List<Course> courses = courseServer.getCourseList();

        for(Course course : courses) {
            System.out.println("Cources " + course.getCourseName());
        }

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("https://www.buildappswithpaulo.com"))
                    .GET().build();
            try{
                HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler);
            }catch(InterruptedException e){

            }

        }catch(URISyntaxException e){
            e.printStackTrace();
        }

    }
}
