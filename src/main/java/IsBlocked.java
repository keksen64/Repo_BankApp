public class IsBlocked {
    //класс отвечающий за проверку наличия блокировки
    public static boolean Check(String kart){
        boolean re = false;
        Select sel = new Select();
        String ans = sel.getAnswerMainAcc("status", " and kart='" + kart + "'");
        if (ans.equals("aktive")){
            re=true;
        }
        else {
            re=false;
        }
        return re;
    }
}
