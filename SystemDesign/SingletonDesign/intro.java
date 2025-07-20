public class Logger{
    public static voatile Logger instance ;
    private Logger(){
        this.instance = new Logger();
    } 
    public static Logger getLogger(){
        if(instance == null){
            synchornized(Logger.class){
                if(instance == null){
                    return new Logger();
                }
            }
        }
        return instance ;
    }
}