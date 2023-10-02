public class CafeJava {
    public static void main (String[] args){

        String generalGreeting = "Welcome to Cafe Java";
        String pendingMessage = ", your order will be ready shorlty";
        String readyMEssage = ", your order is ready";
        String displayTotalMessage = " Your total is $";

        double mochaPrice = 3.5;
        double dripCoffe = 4;
        double cappuchino = 6;
        double latte = 5;
        String customer1 = "Cindhuri";
        String customer2 = "Jim";
        String customer3 = "Noah";
        String customer4 = "Sam";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
        System.out.println(generalGreeting + customer1 + pendingMessage ) ;
        System.out.println(generalGreeting+customer3+readyMEssage+displayTotalMessage+cappuchino);
        System.out.println(generalGreeting+customer4 + displayTotalMessage + 2*latte+pendingMessage);
        System.out.println(generalGreeting+customer2+displayTotalMessage+(latte-dripCoffe));


}
}