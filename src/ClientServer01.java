import java.io.IOException;

//The client server
public class ClientServer01
{
   public static void main(String[] args) throws InterruptedException
   {
      // start the server
      class ServerRunnable implements Runnable
      {
         public void run()
         {
            try
            {
            	ClientServer03.main(null);
            }
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      };
      Thread t1 = new Thread(new ServerRunnable());
      t1.start();
     
     
      // start the client
      class ClientRunnable implements Runnable
      {
         public void run()
         {
            try
            {
            	ClientServer02.main(null);
            }
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      };
     
      Thread t2 = new Thread(new ClientRunnable());
      t2.start();
      t2.join();
      System.exit(0);
   }
}