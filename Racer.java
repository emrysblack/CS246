import java.io.File;
import java.awt.event.ActionListener;

public class Racer
   extends Thread
   implements ActionListener
{
   private int mFileNumber;

   // need to use OutputtingFilerToucher class for display
   public boolean create;
   public Racer()
   {
      mFileNumber = 0;
      create = true;
   }
      public Racer(boolean c)
   {
      mFileNumber = 0;
      create = c;
   }
   
   public File newFileN(int number)
   {
      return new File(String.format("file.%05d", number));
   }
   // creates files
   public void create()
   {
      while (true)
      {
         try
         {
            if (newFileN(mFileNumber).createNewFile())
            {
               mFileNumber++;
            }
            Thread.sleep(500);
         }
         catch (Exception e)
         {
         }
      }
   }
   // destroys files
   public void destroy()
   {
      
      while (true)
      {
         try
         {
            if (newFileN(mFileNumber).delete())
            {
               mFileNumber++;
            }
            Thread.sleep(500);
         }
         catch (Exception e)
         {
         }
      }
   }
   public void run()
   {
      try
      {
         if (create)
         {
            create();
         }
         else
         {
            Thread.sleep(2000);
            destroy();
         }
      }
      catch (Exception e)
      {
      }
   }
   
   public static void main(String[] args)
   {
      new Racer(true).start();
      new Racer(false).start();
   }
}
