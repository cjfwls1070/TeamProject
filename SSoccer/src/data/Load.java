package data;

import java.util.ArrayList;

import DBCENTER.DBload;
import DBCENTER.DBdata;
import store.SPlayer;
import store.Store;
import friend.Friend;

//로그인시 DB에서 불러오는 것들 실행시켜 주고 정보들 가지고 있음
public class Load {
	
	//DB이용
	DBload dbl = new DBload();
	DBdata dbd = new DBdata();
	
	//가지고있는변수들
	protected User u;
	protected Store st;
	protected Team ut;
	protected ArrayList<Player> up;
	protected Friend f;
	protected String id;
	
	
	
	
	public Load(){}
	
	public Load(String id){
		this.id=id;
		st = dbl.loadStore();
		u = dbl.loadUser(id);
		up = dbl.loadPlayer(id);
		ut = dbl.loadTeam(id);
		ut.setPlayer(up);
	}
	
	public Store getStore(){
		return st;
	}
	
	public Team getTeam(){
		return ut;
	}

	public User getUser() {
		return u;
	}
	
	public Friend getFriend(){
		return f;
	}
	
	//추가적으로 여기서 로드작업 외 여러 메소드 실행

	//신규선수구매메소드
	 public void buyNewPlayer(int index){
		 
		SPlayer temp = this.st.buyNewPlayer(index, this.ut);
		ut.addPlayer((Player)temp); //살짝문제생길수 있는부분 SPLAYER,PLAYER 좀더 살펴보기 캐스팅으로 지금은해결
		dbd.putNewPlayer(temp, id);
		u.changeMoney(-temp.getPrice());
		
	}
	 
	 //이적시장선수구매메소드
	 public void buyOldPlayer(int index){
			
		 SPlayer temp = this.st.buyOldPlayer(index, this.ut);
		 ut.addPlayer((Player)temp);
		 dbd.putOldPlayer(temp, id);
		 u.changeMoney(-temp.getPrice());
		 
		}
	 
	 //선수판매메소드
	 public void sellPlayer(int index, int pri){
		 
		 Player temp = this.ut.getPlayer(index);
		 ut.removePlayer(index);
		 st.addoldPlayer(temp.primaryNum, temp.name, temp.shoot, temp.dribble, temp.pass, temp.stamina, temp.tackle, temp.steal, temp.speed, temp.gk, temp.exp, pri);
		 dbd.sellPlayer(temp, pri, id);
		 u.changeMoney(pri);
		 
		 
	 }
}
