/**
 * A template main-method class for use from
 * non-BlueJ IDEs or the command line.
 * 
 * @author djb
 * @version 2015.12.19
 */
public class Main
{
    private Main() {}
    
    public static void main(String[] args)
    {
        Program prog = new Program();
        prog.run();
        prog.finish();
        System.exit(0);
    }
}
