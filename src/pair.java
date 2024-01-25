public class pair{
    private int row;
    private int col;

    pair(int x,int y)
    {
        this.row=x;
        this.col=y;
    }

    public int getfirst()
    {
        return this.row;
    }

    public int getsecond()
    {
        return this.col;
    }

    void update(int x,int y)
    {
        this.row=x;
        this.col=y;
    }
}