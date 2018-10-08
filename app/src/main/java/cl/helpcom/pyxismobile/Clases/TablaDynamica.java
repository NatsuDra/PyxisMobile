package cl.helpcom.pyxismobile.Clases;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TablaDynamica {

    private TableLayout tableLayout;
    private Context context;
    private String[] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView txtCell;
    private int indexC;
    private int indexR;
    private boolean multiColor=false;
    int firtColor,secondColor,textColor;

    public TablaDynamica(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;
    }


    public void addHeader(String[] header){
        this.header=header;
        createHeader();
    }

    public void addData(ArrayList<String[]> data){
        this.data=data;
        createDataTable();
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCell(){
        txtCell= new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(20);
    }

    private void createHeader(){
        indexC=0;
        newRow();
        while (indexC < header.length){
            newCell();
            txtCell.setText(header[indexC++]);
            tableRow.addView(txtCell,newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    public void createDataTable(){
        String info;
        try {
            for (indexR=1;indexR<=header.length;indexR++){
                newRow();
                for (indexC=0;indexC<header.length;indexC++){
                    newCell();
                    String[] row=data.get(indexR-1);
                    info=(indexC<row.length)?row[indexC]:"";
                    txtCell.setText(info);
                    tableRow.addView(txtCell,newTableRowParams());
                }
                tableLayout.addView(tableRow);
            }
        }catch (Exception e){
            Toast.makeText(context, ""+e.toString(), Toast.LENGTH_SHORT).show();

        }

    }

    public void addItems(String[] item){
        String info;
        data.add(item);
        indexC=0;
        newRow();
        while (indexC<header.length){
            newCell();
            info=(indexC<item.length)?item[indexC++]:"";
            txtCell.setText(info);
            tableRow.addView(txtCell,newTableRowParams());
        }
        tableLayout.addView(tableRow,data.size());
        reColoring();

    }
    private TableRow getRow(int index){
        return (TableRow) tableLayout.getChildAt(index);
    }

    public void backgroundHeader(int color){
        indexC=0;
        while (indexC<header.length){
            txtCell=getCell(0,indexC++);
            txtCell.setBackgroundColor(color);
        }
    }

    public void backgroundData(int firtColor,int secondColor){
        try {
            for(indexR=1;indexR<=header.length;indexR++){
                multiColor=!multiColor;
                for(indexC=0;indexC<header.length;indexC++){
                    txtCell=getCell(indexR,indexC);
                    txtCell.setBackgroundColor((multiColor)?firtColor:secondColor);
                }
            }
            this.firtColor=firtColor;
            this.secondColor=secondColor;
        }catch (Exception e){
            Toast.makeText(context, ""+e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    public void lineColor(int color){
        indexR=0;
        while (indexR<data.size()){
            getRow(indexR++).setBackgroundColor(color);
        }
    }

    public void textColorData(int color){
        try{
            for (indexR=1;indexR<=header.length;indexR++){
                for (indexC=0;indexC<header.length;indexC++){
                    getCell(indexR,indexC).setTextColor(color);
                }
                this.textColor=color;
            }
        }catch (Exception e){

        }

    }

    public void textColorHeader(int color){
        indexC=0;
        while (indexC<header.length){
            getCell(0,indexC++).setTextColor(color);
        }
    }

    public void reColoring(){
        indexC=0;
        multiColor=!multiColor;
        while (indexC<header.length){
            txtCell=getCell(data.size(),indexC++);
            txtCell.setBackgroundColor((multiColor)?firtColor:secondColor);
            txtCell.setTextColor(textColor);
        }
    }

    private TextView getCell(int rowIndex,int columIndex){
        tableRow=getRow(rowIndex);
        return (TextView) tableRow.getChildAt(columIndex);
    }

    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params= new TableRow.LayoutParams();
        params.setMargins(2,1,2,1);
        params.weight=1;
        return params;
    }
}
