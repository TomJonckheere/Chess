package model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom
 */
public enum Row{
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private static Map<Integer, Row> rowsByRowNumber = new HashMap<>();

    static {
        for (Row r: Row.values()) {
            rowsByRowNumber.put(r.getRowNumber(),r);
        }
    }

    Row(Integer rowNumber){
        this.rowNumber = rowNumber;
    }

    private Integer rowNumber;

    public Integer getRowNumber()
    {return rowNumber;}


    public static Row getByRowNumber(Integer row)
    {
        return rowsByRowNumber.get(row);
    }
}
