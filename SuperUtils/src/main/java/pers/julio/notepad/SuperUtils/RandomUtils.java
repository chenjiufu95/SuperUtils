package pers.julio.notepad.SuperUtils;

import java.util.Random;

/**
 * ClassName:  RandomUtils
 * Description: 随机数 工具类
 * Author;  julio_chan  2020/5/7 10:33
 */
public class RandomUtils {
    /**
     * 随机生成布尔值
     * @return
     */
    public static boolean getBoolean() {
        Random random = new Random();
        return random.nextInt(10) < 5;
    }

    /**
     * 生成一个0 到 endNum 之间的随机数(不包含endNum的随机数)
     * @param endNum
     * @return
     */
    public static int getNum(int endNum){
        if(endNum > 0){
            Random random = new Random();
            return random.nextInt(endNum);
        }
        return 0;
    }

    /**
     * 生成一个startNum 到 endNum之间的随机数(不包含endNum的随机数)
     * @param startNum
     * @param endNum
     * @return
     */
    public static int getNum(int startNum, int endNum){
        if(endNum > startNum){
            Random random = new Random();
            return random.nextInt(endNum - startNum) + startNum;
        }
        return 0;
    }


    /**
     * 生成随机大写字母
     * @return
     */
    public static String getLargeLetter(){
        Random random = new Random();
        return String.valueOf ((char) (random.nextInt(27) + 'A'));
    }

    /**
     * 生成随机大写字母字符串
     * @return
     */
    public static String getLargeLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            buffer.append((char) (random.nextInt(27) + 'A'));
        }
        return buffer.toString();
    }

    /**
     * 生成随机小写字母
     * @return
     */
    public static String getSmallLetter(){
        Random random = new Random();
        return String.valueOf ((char) (random.nextInt(27) + 'a'));
    }

    /**
     * 生成随机小写字母字符串
     * @return
     */
    public static String getSmallLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            buffer.append((char) (random.nextInt(27) + 'a'));
        }
        return buffer.toString();
    }

    /**
     * 数字与小写字母混编字符串
     * @param size
     * @return
     */
    public static String getNumSmallLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            if(random.nextInt(2) % 2 == 0){//字母
                buffer.append((char) (random.nextInt(27) + 'a'));
            }else{//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    /**
     * 数字与大写字母混编字符串
     * @param size
     * @return
     */
    public static String getNumLargeLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            if(random.nextInt(2) % 2 == 0){//字母
                buffer.append((char) (random.nextInt(27) + 'A'));
            }else{//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    /**
     * 数字与大小写字母混编字符串
     * @param size
     * @return
     */
    public static String getNumLargeSmallLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            if(random.nextInt(2) % 2 == 0){//字母
                if(random.nextInt(2) % 2 == 0){
                    buffer.append((char) (random.nextInt(27) + 'A'));
                }else{
                    buffer.append((char) (random.nextInt(27) + 'a'));
                }
            }else{//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    /** 生成随机字符串(方法1)
     * @param length  生成字符串的长度
     * @return  生成的字符串
     * @throws NumberFormatException
     */
    public static String getRandomString(int length) throws NumberFormatException {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //String str="1234567890";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    /** 生成随机字符串(方法2)
     * @param length  生成字符串的长度
     * @return  生成的字符串
     * @throws NumberFormatException
     */
    public static String getRandomString2(int length) {
        //产生随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //循环length次
        for (int i = 0; i < length; i++) {
            //产生0-2个随机数，既与a-z，A-Z，0-9三种可能
            int number = random.nextInt(3);
            long result = 0;

            switch (number) {
                //如果number产生的是数字0；
                case 0:
                    //产生A-Z的ASCII码
                    result = Math.round(Math.random() * 25 + 65);
                    //将ASCII码转换成字符
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    //产生a-z的ASCII码
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    //产生0-9的数字
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}
