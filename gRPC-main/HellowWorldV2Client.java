public static void main(String[] args) throws Exception {
    String firstName = "Mohamed Habib";
    String lastName = "Manai";

    String target = "localhost:50051";


    ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
            .build();

    try {
        HelloWorldClient client = new HelloWorldClient(channel);
        String fullName = firstName + " " + lastName;
        client.greet(fullName);
    } finally {
       
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
}
