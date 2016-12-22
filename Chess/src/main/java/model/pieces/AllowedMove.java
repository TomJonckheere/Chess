package model.pieces;

/**
 * @author Tom
 */
public class AllowedMove {

    private Integer rowIncrement;
    private Integer columnIncrement;
    private Boolean canAlwaysBeDone;

    public AllowedMove(Integer rowIncrement, Integer columnIncrement)
    {
        this.rowIncrement = rowIncrement;
        this.columnIncrement = columnIncrement;
        this.canAlwaysBeDone = true;
    }

    public AllowedMove(Integer rowIncrement, Integer columnIncrement, Boolean canAlwaysBeDone)
    {
        this.rowIncrement = rowIncrement;
        this.columnIncrement = columnIncrement;
        this.canAlwaysBeDone = canAlwaysBeDone;
    }

    public Integer getRowIncrement()
    {
        return rowIncrement;
    }

    public Integer getColumnIncrement()
    {
        return columnIncrement;
    }

    public Boolean getCanAlwaysBeDone()
    {
        return canAlwaysBeDone;
    }

}
