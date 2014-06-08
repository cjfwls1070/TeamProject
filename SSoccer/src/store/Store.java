package store;

import java.util.ArrayList; //arrayList戚遂

import data.Player;
import data.Team;

public class Store {

	//重鋭識呪 鯉系
	ArrayList<SPlayer> newPlayer = new ArrayList<SPlayer>();
	//奄糎紫遂切亜 紫遂馬揮 識呪鯉系
	ArrayList<SPlayer> oldPlayer = new ArrayList<SPlayer>();
	//重鋭識呪 String 鯉系
	ArrayList<String> np = new ArrayList<String>();
	//奄糎紫遂切 String 鯉系
	ArrayList<String> op = new ArrayList<String>();
	
	

	
	
	public Store(){
		
	}
	
	public SPlayer buyNewPlayer(int index, Team team){
		
		SPlayer temp = newPlayer.get(index);
		team.addPlayer(temp);
		return temp;
		
	}
	
    public SPlayer buyOldPlayer(int index, Team team){
		
    	SPlayer temp = oldPlayer.get(index);
		team.addPlayer(temp);
		
		//oldplayer税 井酔澗 雌繊引 鯉系拭辞 肢薦
		oldPlayer.remove(index);
		op.remove(index);
		
		return temp;
		
	}
	
	
	//重鋭識呪 鯉系拭 識呪 蓄亜 + String鯉系拭亀 蓄亜
	public void addnewPlayer(int pN, String n, int s, int d, int p, int st, int tk, int sl,
			int sp, int gk, int exp, int price){
		
		SPlayer temp = new SPlayer(pN, n,s,d,p,st,tk,sl,sp,gk,exp,price);
		newPlayer.add(temp);
		np.add(temp.toString());
		
		
	}
	
	//奄糎識呪 鯉系拭 識呪 蓄亜 + String鯉系拭亀 蓄亜
	public void addoldPlayer(int pN, String n, int s, int d, int p, int st, int tk, int sl,
			int sp, int gk, int exp,  int price){
		
		SPlayer temp = new SPlayer(pN, n,s,d,p,st,tk,sl,sp,gk,exp,price);
		oldPlayer.add(temp);
		op.add(temp.toString());
	}
	
	//重鋭識呪 getter
	public ArrayList getNewPlayer(){
		
		return this.newPlayer;
		
	}
	
	//奄糎紫遂切亜 紫遂馬揮 識呪 getter
    public ArrayList getOldPlayer(){
		
		return this.oldPlayer;
		
	}
    
    //重鋭識呪 String[] getter
    public String[] getnp(){
    	
    	String[] temp= this.np.toArray(new String[np.size()]); //arrayList -> String[]	
    	return temp;
    }

    //奄糎紫遂切亜 紫遂馬揮 識呪 String[] getter
    public String[] getop(){
    	
    	String[] temp= this.op.toArray(new String[op.size()]); //arrayList -> String[]	
    	return temp;
    }
    
    public SPlayer getNewPlayerIndex(int index){
    	return newPlayer.get(index);
    }
    
    public SPlayer getOldPlayerIndex(int index){
    	return oldPlayer.get(index);
    }
    
    //管径帖伊事 採歳
    //重鋭識呪 管径帖伊事
    public String[] searchNewPlayer(String s, String d, String p, String st, String t, String sl, String sp, String gk){
    	
    	//爪左酵什稽 穿含閤精 葵級 int稽 痕発
    	int snum = Integer.parseInt(s);
    	int dnum = Integer.parseInt(d);
    	int pnum = Integer.parseInt(p);
    	int stnum = Integer.parseInt(st);
    	int tnum = Integer.parseInt(t);
    	int slnum = Integer.parseInt(sl);
    	int spnum = Integer.parseInt(sp);
    	int gknum = Integer.parseInt(gk);
    	
    	//繕闇拭 背雁馬澗 識呪級 閤澗 績獣 軒什闘 
    	ArrayList<SPlayer> templist = new ArrayList<SPlayer>();
    	
    	for(int i=0; i<newPlayer.size(); i++){
    		
    		//搾嘘研 是背 背雁識呪税 痕呪級 亜閃身
    		int psnum = newPlayer.get(i).shoot;
    		int pdnum = newPlayer.get(i).dribble;
    		int ppnum =  newPlayer.get(i).pass;
    		int pstnum =  newPlayer.get(i).stamina;
    		int ptnum =  newPlayer.get(i).tackle;
    		int pslnum =  newPlayer.get(i).steal;
    		int pspnum =  newPlayer.get(i).speed;
    		int pgknum =  newPlayer.get(i).gk;
    		
    		//巷走延 繕闇 降持 .. . . .  8亜走 .. せせせ8亜走繕闇限蓄澗闇 切政亀 株壱 疏焼左戚蟹 叔霜旋生経 神備形蝕反引劾牛ば
    		if(psnum>=snum && pdnum>=dnum && ppnum>=pnum && pstnum>=stnum && ptnum>=tnum && pslnum>=slnum && pspnum>=spnum && pgknum>=gknum){
    			
    			//繕闇拭 背雁馬澗 識呪 績獣軒什闘拭 蓄亜
    			templist.add(newPlayer.get(i));
    			
    		}
    		
    		//gk旭戚 and床艦 伊事戚 格巷 照蟹人辞 魚稽 皐叶 茨徹遁澗 gk皐壱 乞窮 管径帖亜
    		//50 戚馬虞辞 陥楳戚亀 是拭辞 掻差鞠走 省製 ぞぞ
    		//戚 杏稽 茨徹遁幻 瑳 呪 赤走幻 識呪級 左形檎 00戚雌生稽 竺舛背醤敗
    		if(pgknum>=gknum){
    			templist.add(newPlayer.get(i));
    		}
    		
    	}
    	
    	//戚薦 繕闇拭 背雁馬澗 識呪級 String[] 郊蚊爽奄
    	
    	String[] temp = new String[templist.size()];
    	
    	for(int i=0; i<templist.size(); i++){
    		temp[i] = templist.get(i).toString();
    	}
    	
    	return temp;
   
    }
    
  //奄糎識呪 管径帖伊事
    public String[] searchOldPlayer(String s, String d, String p, String st, String t, String sl, String sp, String gk){
    	
    	//爪左酵什稽 穿含閤精 葵級 int稽 痕発
    	int snum = Integer.parseInt(s);
    	int dnum = Integer.parseInt(d);
    	int pnum = Integer.parseInt(p);
    	int stnum = Integer.parseInt(st);
    	int tnum = Integer.parseInt(t);
    	int slnum = Integer.parseInt(sl);
    	int spnum = Integer.parseInt(sp);
    	int gknum = Integer.parseInt(gk);
    	
    	//繕闇拭 背雁馬澗 識呪級 閤澗 績獣 軒什闘 
    	ArrayList<SPlayer> templist = new ArrayList<SPlayer>();
    	
    	for(int i=0; i<oldPlayer.size(); i++){
    		
    		//搾嘘研 是背 背雁識呪税 痕呪級 亜閃身
    		int psnum = oldPlayer.get(i).shoot;
    		int pdnum = oldPlayer.get(i).dribble;
    		int ppnum =  oldPlayer.get(i).pass;
    		int pstnum =  oldPlayer.get(i).stamina;
    		int ptnum =  oldPlayer.get(i).tackle;
    		int pslnum =  oldPlayer.get(i).steal;
    		int pspnum =  oldPlayer.get(i).speed;
    		int pgknum =  oldPlayer.get(i).gk;
    		
    		//巷走延 繕闇 降持 .. . . .  8亜走 .. せせせ8亜走繕闇限蓄澗闇 切政亀 株壱 疏焼左戚蟹 叔霜旋生経 神備形蝕反引劾牛ば
    		if(psnum>=snum && pdnum>=dnum && ppnum>=pnum && pstnum>=stnum && ptnum>=tnum && pslnum>=slnum && pspnum>=spnum){
    			
    			//繕闇拭 背雁馬澗 識呪 績獣軒什闘拭 蓄亜
    			templist.add(oldPlayer.get(i));
    			
    		}
    		
    		//gk旭戚 and床艦 伊事戚 格巷 照蟹人辞 魚稽 皐叶 茨徹遁澗 gk皐壱 乞窮 管径帖亜
    		//50 戚馬虞辞 陥楳戚亀 是拭辞 掻差鞠走 省製 ぞぞ
    		//戚 杏稽 茨徹遁幻 瑳 呪 赤走幻 識呪級 左形檎 00戚雌生稽 竺舛背醤敗
    		if(pgknum>=gknum){
    			templist.add(oldPlayer.get(i));
    		}
    		
    	}
    	
    	//戚薦 繕闇拭 背雁馬澗 識呪級 String[] 郊蚊爽奄
    	
    	String[] temp = new String[templist.size()];
    	
    	for(int i=0; i<templist.size(); i++){
    		temp[i] = templist.get(i).toString();
    	}
    	
    	return temp;
   
    }
    
}
