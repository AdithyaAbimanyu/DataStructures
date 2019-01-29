import java.io.*;
import java.util.*;

public class Index
{
    public static final String store_path = "E:"+File.separator+"storeData";
    public static void main(String args[])
    {
        long time=System.currentTimeMillis();
        List<File> listOffiles = new ArrayList<>();
        String path = "D:"+File.separator+"RULE_BUILDER-client"+File.separator+"ela_client"+File.separator+"jsapps"+File.separator+"emberapp";
        File storePath = new File(store_path);
        if(!storePath.exists())
        {
            storePath.mkdir();
        }
        TernarySearch root = null;
        root = getObject(path);
        if(root==null)
        {
            File file = new File(path);
            if(!file.exists())
            {
                System.out.println("Please enter valid directory");
                return;
            }
            if(file.isDirectory())
            {
                listOffiles = Arrays.asList(file.listFiles());
                handleDirectory(listOffiles);
            }
            else
            {
                handleFile(file);
            }
            storeRoot(TernarySearchImpl.getRoot(),path);
        }
        else
        {
            TernarySearchImpl.setRoot(root);
        }
//        System.out.println("call crawl");
//        TernarySearchImpl.getAllWord();


//        System.out.println("find word");

        TernarySearchImpl.getWordList("GlobalStore".toLowerCase());
        System.out.println(System.currentTimeMillis()-time);
    }

    private static void storeRoot(TernarySearch root, String path)
    {
        OutputStream os=null;
        ObjectOutputStream oos=null;
        File f = new File(store_path+File.separator+path.replaceAll(":","").replaceAll("\\\\","").replaceAll(" ","")+".dat");
        if(!f.exists())
        {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try
        {
            os= new FileOutputStream(f);
            oos= new ObjectOutputStream(os);
            oos.writeObject(root);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                oos.flush();
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static TernarySearch getObject(String path)
    {
        TernarySearch root=null;
        InputStream is=null;
        ObjectInputStream ois=null;
        File f = new File(store_path+File.separator+path.replaceAll(":","").replaceAll("\\\\","").replaceAll(" ","")+".dat");
        if(!f.exists())
        {
            return null;
        }
        try {
            is =new FileInputStream(f);
            ois = new ObjectInputStream(is);
            root = (TernarySearch) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return root;
    }

    private static void handleDirectory(List<File> listOffiles)
    {
        Iterator<File> iterator = listOffiles.iterator();
        while(iterator.hasNext())
        {
            File f= iterator.next();
            if(f.isDirectory())
            {
                handleDirectory(Arrays.asList(f.listFiles()));
            }
            else
            {
                handleFile(f);
            }
        }
    }

    private static void handleFile(File file)
    {
        try
        {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
            String line="";
            while((line = bf.readLine())!=null)
            {
                String inputs[] = line.split("[\\p{Punct}\\s]+");
                for(String s:inputs)
                {
                    if(!s.isEmpty())
                    {
                        TernarySearchImpl.add(s.toLowerCase());
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
