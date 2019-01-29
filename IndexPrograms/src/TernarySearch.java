import java.io.Serializable;

public class TernarySearch implements Serializable
{
    boolean isWord;
    char letter;
    TernarySearch next[];

    public TernarySearch(char let)
    {
        letter = let;
        this.isWord = false;
        next =new TernarySearch[3];
    }

    public static TernarySearch add(TernarySearch node,String str,int pos)
    {
        if(pos == str.length())
        {
            return node;
        }
        if(node == null)
        {
            node = new TernarySearch(str.charAt(pos++));
            node.next[1] = add(node.next[1], str, pos);
            if(node.next[1]==null)
            {
                node.isWord=true;
            }
        }
        else if(node.letter<str.charAt(pos))
        {
            node.next[2]=add(node.next[2],str,pos);
        }
        else if(node.letter>str.charAt(pos))
        {
            node.next[0]=add(node.next[0],str,pos);
        }
        else
        {
            pos++;
            node.next[1]=add(node.next[1],str,pos);
        }
        return node;
    }

    public static void crawlTernaryTree(TernarySearch root,String s)
    {
        if(root==null)
        {
            return;
        }
        if(root.isWord)
        {
            System.out.println(s+root.letter);
        }
        crawlTernaryTree(root.next[0],s);
        crawlTernaryTree(root.next[1],s+root.letter);
        crawlTernaryTree(root.next[2],s);
    }

    public static void getAllWords(TernarySearch root, String str,String word,int pos)
    {
        if(root == null)
        {
            return;
        }
        TernarySearch crawl = findTreePos(root,null,str,pos,str.length()-1);
        if(crawl.isWord)
        {
            System.out.println(str);
        }
        crawlTernaryTree(crawl.next[1],str);

    }

    private static TernarySearch findTreePos(TernarySearch root,TernarySearch res, String str,int pos,int len)
    {
        if(pos == len)
        {
            return root;
        }
        if(root == null )
        {
            return null;
        }
        if(root.letter == str.charAt(pos))
        {
            res=findTreePos(root.next[1],res,str,++pos,len);
        }
        else if(root.letter > str.charAt(pos))
        {
           res=findTreePos(root.next[0],res,str,pos,len);
        }
        else if(root.letter < str.charAt(pos))
        {
           res=findTreePos(root.next[2],res,str,pos,len);
        }
        return res;
    }
}
