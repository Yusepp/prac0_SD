package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ComUtilsService {
    private ComUtils comUtils;
    private static final int STRING = 0, INT = 1,VARIABLE = 2,CHAR = 3;
    public ComUtilsService(InputStream inputStream, OutputStream outputStream) throws IOException {
        comUtils = new ComUtils(inputStream, outputStream);
    }

    public void writeTest(int type, String data,int size) throws IOException {
        try {
            switch (type) {
                case STRING:
                    comUtils.write_string(data);
                    break;
                case INT:
                    comUtils.write_int32(Integer.parseInt(data));
                    break;
                case VARIABLE:
                    comUtils.write_string_variable(size, data);
                    break;
                case CHAR:
                    comUtils.writeChar(data);
                    break;
                default:
                    break;

            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String readTest(int type,int size) throws IOException{
        String result = "";
        try {
            switch (type) {
                case STRING:
                    result = comUtils.read_string();
                    break;
                case INT:
                    result = Integer.toString(comUtils.read_int32());
                    break;
                case VARIABLE:
                    result = comUtils.read_string_variable(size);
                    break;
                case CHAR:
                    result = String.valueOf(comUtils.readChar());
                    break;
                default:

            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }



}
