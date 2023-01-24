import java.util.Scanner;

public class Editor {
    private Scanner sc = new Scanner(System.in);

    public String[][] editSelector(String[][] data){
        String[][] newData = null;
        System.out.println("Do you want to change a column(1), add/remove a column(2), change a row(3), add/remove a row(4) \n\n");
        int changeVariant = sc.nextInt();

        switch(changeVariant){
            case 1:
                newData = changeColumn(data);
                break;
            case 2:
                newData = cdColumn(data);
                break;
            case 3:
                newData = changeRow(data);
                break;
            case 4:
                newData = cdRow(data);
                break;
            default:
            System.out.println("invalid input");
        }
        
        if(newData != null && repeat("select another edit variant?")){
            newData = editSelector(newData);
        }
        return newData;
    }

    private String[][] changeColumn(String[][] data){
        for (int i = 0; i < data[0].length; i++){
            System.out.print(data[0][i]+" ("+i+") | ");
        }
        System.out.println("\nPlease input the number of the column you want to edit:");
        int changeInt = sc.nextInt();
        if (changeInt < 0 || changeInt >= data.length) {
            System.out.println("invalid input");
            return data;
        }

        System.out.println("\n\nInput the new column name");
        data[0][changeInt] = sc.nextLine();
        
        if(repeat("change another column?")){
            data = changeColumn(data);
        }

        return data;
    }

    private String[][] cdColumn(String[][] data){
        String[][] newData = null;

        System.out.println("Do you want to remove (1), or add (2) a column?");
        int pathInt = sc.nextInt();
        switch(pathInt){
            case 1:
                newData = removeColumn(data);
                break;
            case 2:
                newData = addColumn(data);
                break;
            default:
            System.out.println("invalid input");
        }
        if(newData != null && repeat("create or delete another column?")){
            newData = cdColumn(newData);
        }

        return newData;
    }

    private String[][] removeColumn(String[][] data){
        for (int i = 0; i < data[0].length; i++){
            System.out.print(data[0][i]+" ("+i+") | ");
        }
        System.out.println("\nPlease input the number of the column you want to remove:");
        int deleteInt = sc.nextInt();
        if (deleteInt < 0 || deleteInt >= data[0].length) {
            System.out.println("invalid input");
            return data;
        }

        String[][] newData = new String[data.length][data[0].length-1];
        for (int j = 0; j < data.length; j++){
            for(int i = 0, k = 0; i < data[0].length; i++){
                if(i == deleteInt){
                    continue;
                }
    
                newData[j][k++] = data[j][i];
            }
        }
        return newData;
    }

    private String[][] addColumn(String[][] data){
        System.out.println("Input the name of the new Column:");
        String name = sc.nextLine();
        String[][] newData = new String[data.length][data[0].length+1];
        for (int j = 0; j < data.length; j++){
            for(int i = 0; i <= data[0].length; i++){
                if(i == data[0].length){
                    if(j == 0){
                        newData[j][i] = name;
                    }
                    else{
                        System.out.println("Input the Value for you new Column in row "+(j+1));
                        newData[j][i] = sc.nextLine();
                    }
                    continue;
                }
                newData[j][i] = data[j][i];
            }
        }
        return newData;
    }

    private String[][] changeRow(String[][] data){
        for (int j = 0; j < data.length; j++){
            System.out.print(" ("+j+") |    ");
            for (int i = 0; i < data[0].length; i++){
                System.out.print(data[j][i]+" | ");
            }
        }
        System.out.println("\nPlease input the number of the row you want to change (row 0 can't be changed, please use the change column function or that):");
        int changeInt = sc.nextInt();
        if (changeInt < 1 || changeInt >= data.length) {
            System.out.println("invalid input");
            return data;
        }

        for(int i = 0; i < data[0].length; i++){
            System.out.println("Input the Value for your new row in Column "+data[0][i]);
            data[changeInt][i] = sc.nextLine();
        }

        if(repeat("change another row?")){
            data = changeColumn(data);
        }

        return data;
    }

    private String[][] cdRow(String[][] data){
        String[][] newData = null;

        System.out.println("Do you want to remove (1), or add (2) a row?");
        int pathInt = sc.nextInt();
        switch(pathInt){
            case 1:
                newData = removeRow(data);
                break;
            case 2:
                newData = addRow(data);
                break;
            default:
            System.out.println("invalid input");
        }
        if(newData != null && repeat("create or delete another row?")){
            newData = cdRow(newData);
        }

        return newData;
    }

    private String[][] removeRow(String[][] data){
        for (int j = 0; j < data.length; j++){
            System.out.print(" ("+j+") |    ");
            for (int i = 0; i < data[0].length; i++){
                System.out.print(data[j][i]+" | ");
            }
        }
        System.out.println("\nPlease input the number of the row you want to remove (row 0 can't be removed):");
        int deleteInt = sc.nextInt();
        if (deleteInt < 1 || deleteInt >= data.length) {
            System.out.println("invalid input");
            return data;
        }

        String[][] newData = new String[data.length-1][data[0].length];
        
        for(int i = 0, k = 0; i < data.length; i++){
            if(i == deleteInt){
                continue;
            }

            newData[k++] = data[i];
        }
        return newData;
    }

    private String[][] addRow(String[][] data){

        String[][] newData = new String[data.length+1][data[0].length];
        for (int j = 0; j <= data.length; j++){
            for(int i = 0; i < data[0].length; i++){
                if(j == data.length){
                    System.out.println("Input the Value for your new row in Column "+data[0][i]);
                    newData[j][i] = sc.nextLine();
                    continue;
                }
                newData[j] = data[j];
                break;
            }
        }
        return newData;
    }

    private boolean repeat(String variant){
        System.out.println("Do you want to "+variant+" Y/N");
        String confirmation = sc.nextLine();

        if (confirmation.equals("y") || confirmation.equals("Y"))
        {
            return true;
        }
        return false;
    }
    
}
