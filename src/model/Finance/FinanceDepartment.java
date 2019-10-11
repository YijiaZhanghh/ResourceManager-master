package model.Finance;

import model.exceptions.LoadFailException;
import model.exceptions.isNegException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FinanceDepartment implements Loadable, Savable{
    private static final String FILE_PATH = ".\\data\\balance.txt";

    private static FinanceDepartment instancce = new FinanceDepartment();
    private int currentBalance;

    public static FinanceDepartment getInstancce() {
        return instancce;
    }

    private FinanceDepartment(){
        currentBalance = 0;
    }

    public void save()throws IOException {
        File file = new File(FILE_PATH);

        List<String> lines = new ArrayList<>();
        lines.add(String.valueOf(currentBalance));

        Files.write(file.toPath(), lines);
    }
    //REQUIRES:
    //MODIFIES: this,changeIncome
    //EFFECTS: input expenditure to subtract from balance, input income to add to balance
    @Override
    public String load() throws IOException, LoadFailException {
        File file = new File(FILE_PATH);
        List<String> line = (Files.readAllLines(file.toPath()));
//        for (String s : line) {
//        Income i = new Income();
////        i.setResult(Integer.parseInt(input[1]));
////        i.setOperation(input[0]);
//        changeIncome.add(i);
//        }
        try {
            currentBalance = Integer.parseInt(line.get(line.size()-1));
        } catch (NumberFormatException e) {
            throw new LoadFailException();
        }
        return(line.get(line.size()-1));
    }

        //REQUIRES: toAdd to be positive
    //MODIFIES: income
    //EFFECTS: to add to balance
    public int addIn(int toAdd) throws isNegException {
        if (toAdd<0){
            throw new isNegException("to add is negative!!!");
        }
        //changeIncome.add(income);
        currentBalance += toAdd;
        return currentBalance;
    }

    //REQUIRES: toMinus to be positive
    //MODIFIES: income
    //EFFECTS: to subtract from balance
    public int minusIn(int toMinus) throws isNegException {
        if(toMinus<0){
            throw new isNegException("asdfjvhmk");
        }
        //changeIncome.add(income);
        currentBalance -= toMinus;
        return currentBalance;
    }

    public int getBalance() {
        return currentBalance;
    }
}
