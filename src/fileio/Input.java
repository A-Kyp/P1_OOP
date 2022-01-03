package fileio;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;

public class Input {
    private InitialData initialData = new InitialData();
    private ArrayList<AnnualChange> annualChanges = new ArrayList<>();
    private static Input INSTANCE = null;

    private Input() { }

    public static Input getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Input();
        }
        return INSTANCE;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public void setAnnualChanges(ArrayList<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public ArrayList<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    //    public Input(InitialData initialData, ArrayList<AnnualChange> annualChanges) {
//        this.initialData = initialData;
//        this.annualChanges = annualChanges;
//    }
}
