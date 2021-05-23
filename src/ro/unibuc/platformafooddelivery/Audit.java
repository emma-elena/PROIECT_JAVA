package ro.unibuc.platformafooddelivery;

import java.text.SimpleDateFormat;
import java.util.Date;

//obiect de transport
public class Audit {

    private String actiune;
    private Date dataActiunii;

    public Audit(String actiune, Date dataActiunii) {
        this.actiune = actiune;
        this.dataActiunii = dataActiunii;
    }

    public String getActiune() {
        return actiune;
    }

    public void setActiune(String actiune) {
        this.actiune = actiune;
    }

    public Date getDataActiunii() {
        return dataActiunii;
    }

    public void setDataActiunii(Date dataActiunii) {
        this.dataActiunii = dataActiunii;
    }

    @Override //tip CSV
    public String toString() {
        return  actiune + ',' + new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss").format(dataActiunii);
    }
}

