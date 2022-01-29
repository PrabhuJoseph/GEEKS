package design.copyTable;

/*

 Type of INPUTs - TableData
 TableData.Print() ==> "microsoft"
 
   INPUT # 1:
   
     #1 --> 'm' -> 'i' ->'c'
     #2 --> ''
     #3 -->
     #4 --> 'r' -> 'o'
     #5 --> 's' -> 'o' -> 'f'
     #6 --> 't'
     
   INPUT # 2 :
   
     #1 --> '' -> ''
     #2 --> ''
     #3 --> '' -> ''
     #4 --> '' -> ''
     #5 -->
     #6 --> ''
     #7 --> '' -> '' -> ''
     
   COPY ( I1, I2 )

*/

import java.util.ArrayList;

class CopyTable {

    static class Chars {
        public Chars(char[] columns) {
            this.columns = columns;
        }
        char[] columns;

        private char[] getColumns() {
            return columns;
        }
    }

    public Character getNext(ArrayList<Chars> src) {
        if (di < src.size()) {
            if (dj < src.get(di).getColumns().length) {
                return src.get(di).getColumns()[dj++];
            } else {
                di++;
                dj = 0;
                return getNext(src);
            }
        }
        return null;
    }
    static int di = 0, dj = 0;

    private void copy(ArrayList<Chars> src, ArrayList<Chars> dest) {
        outer: for (Chars x : dest) {
            char[] columns = x.getColumns();
            for (int i=0; i<columns.length; i++) {
                Character cc = getNext(src);
                if (cc == null)
                    break outer;
                columns[i] = cc;
            }
        }
    }

    private void print(ArrayList<Chars> input) {
        for (Chars x : input) {
            for (char c : x.getColumns()) {
              if (c != ' ')
              System.out.print(c);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Chars> table1 = new ArrayList<Chars>();
        table1.add(new Chars(new char[]{'m','i','c'}));
        table1.add(new Chars(new char[]{' '}));
        table1.add(new Chars(new char[]{}));
        table1.add(new Chars(new char[]{'r','o'}));
        table1.add(new Chars(new char[]{'s','o','f'}));
        table1.add(new Chars(new char[]{'t'}));

        ArrayList<Chars> table2 = new ArrayList<Chars>();
        table2.add(new Chars(new char[]{' ',' '}));
        table2.add(new Chars(new char[]{' '}));
        table2.add(new Chars(new char[]{' ',' '}));
        table2.add(new Chars(new char[]{' ',' '}));
        table2.add(new Chars(new char[]{}));
        table2.add(new Chars(new char[]{' ',' ',' '}));

        CopyTable cObj = new CopyTable();

        cObj.copy(table1, table2);
        cObj.print(table2);
    }
}



   
   