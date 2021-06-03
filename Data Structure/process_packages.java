import java.io.IOException;
import java.util.*;

class process_packages {
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    private static void PrintResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if(response.start_time!=-1)
            System.out.println(response.start_time - response.process);
            else
            System.out.println(response.start_time);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = ReadQueries(scanner);
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        PrintResponses(responses);
    }
}

class Request {
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }

    public int arrival_time;
    public int process_time;
}

class Response {
    public Response(int process, int start_time) {
        this.process=process;
        this.start_time = start_time;
    }

    public int process;
    public int start_time;
}

class Buffer {
    public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new ArrayList();
    }

    public Response Process(Request request) {
        if(finish_time_.size()==size_ && finish_time_.get(0)<=request.arrival_time){
           finish_time_.add(Math.max(request.process_time + request.arrival_time, finish_time_.get(finish_time_.size()-1) + request.process_time));
            finish_time_.remove(0);
            return new Response(request.process_time, finish_time_.get(finish_time_.size()-1));
        } 
        else if(finish_time_.size()==size_ && finish_time_.get(0)>request.arrival_time){
            return new Response(request.process_time, -1);
        }
        else if(finish_time_.size()==0){
            finish_time_.add(request.arrival_time + request.process_time);
            return new Response(request.process_time, finish_time_.get(finish_time_.size()-1));
        } 
        else{
            finish_time_.add(Math.max(request.process_time + request.arrival_time, finish_time_.get(finish_time_.size()-1) + request.process_time));
            return new Response(request.process_time, finish_time_.get(finish_time_.size()-1));
        }
    }

    private int size_;
    private ArrayList<Integer> finish_time_;
}
