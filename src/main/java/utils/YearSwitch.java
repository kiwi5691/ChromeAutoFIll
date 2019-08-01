package utils;

/**
 * @auther kiwi
 * @Date 2019/8/1 22:53
 */
public class YearSwitch {
    public static String  yearIndexChanger(String year){

        String tempYear=year;
        int temp = Integer.valueOf(tempYear);
        if(temp==2019){
            tempYear="//*[@id=\"jznf\"]/option[27]";
        }
        else if(temp==2018)
        {
            tempYear="//*[@id=\"jznf\"]/option[26]";
        }
        else if(temp==2017)
        {
            tempYear="//*[@id=\"jznf\"]/option[25]";
        }
        else if(temp==2016)
        {
            tempYear="//*[@id=\"jznf\"]/option[24]";
        }
        else if(temp==2015)
        {
            tempYear="//*[@id=\"jznf\"]/option[23]";
        }
        else if(temp==2014)
        {
            tempYear="//*[@id=\"jznf\"]/option[22]";
        }
        else if(temp==2013)
        {
            tempYear="//*[@id=\"jznf\"]/option[21]";
        }
        else if(temp==2012)
        {
            tempYear="//*[@id=\"jznf\"]/option[20]";
        }
        else if(temp==2011)
        {
            tempYear="//*[@id=\"jznf\"]/option[19]";
        }
        else if(temp==2010)
        {
            tempYear="//*[@id=\"jznf\"]/option[18]";
        }
        else if(temp==2009)
        {
            tempYear="//*[@id=\"jznf\"]/option[17]";
        }else if(temp==2008)
        {
            tempYear="//*[@id=\"jznf\"]/option[16]";
        }
        else if(temp==2007)
        {
            tempYear="//*[@id=\"jznf\"]/option[15]";
        }
        else if(temp==2006)
        {
            tempYear="//*[@id=\"jznf\"]/option[14]";
        }
        else if(temp==2005)
        {
            tempYear="//*[@id=\"jznf\"]/option[13]";
        }
        else if(temp==2004)
        {
            tempYear="//*[@id=\"jznf\"]/option[12]";
        }else if(temp==2003)
        {
            tempYear="//*[@id=\"jznf\"]/option[11]";
        }else if(temp==2002)
        {
            tempYear="//*[@id=\"jznf\"]/option[10]";
        }else if(temp==2001)
        {
            tempYear="//*[@id=\"jznf\"]/option[9]";
        }
        else if(temp==2000)
        {
            tempYear="//*[@id=\"jznf\"]/option[8]";
        }
        else if(temp<2000&&temp>=1990)
        {
            tempYear="//*[@id=\"jznf\"]/option[7]";
        }
        else if(temp<1990&&temp>=1980)
        {
            tempYear="//*[@id=\"jznf\"]/option[6]";
        }
        else if(temp<1980&&temp>=1970)
        {
            tempYear="//*[@id=\"jznf\"]/option[5]";
        }
        else if(temp<1970&&temp>=1960)
        {
            tempYear="//*[@id=\"jznf\"]/option[4]";
        }
        else if(temp<1960&&temp>=1950)
        {
            tempYear="//*[@id=\"jznf\"]/option[3]";
        }
        else if(temp<1950)
        {
            tempYear="//*[@id=\"jznf\"]/option[2]";
        }






        return tempYear;
    }
}
