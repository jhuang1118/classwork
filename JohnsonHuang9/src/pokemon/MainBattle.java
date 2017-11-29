package pokemon;

public class MainBattle {

	public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 System.out.println("Squirtle is preparing to attack with water blast");
		 squirtle.attack(bulbasaur, new Attack() {
		 
		 public void attack(Pokemon target) {
		 int hp = target.getHp();
		 target.setHp(hp/2);
		 }
		 });
		 System.out.println("Bulbasaur is preparing to attack with poison.");
		 bulbasaur.attack(squirtle, new Attack() {
		 
		 public void attack(Pokemon target) {
		 target.setPoisoned(true);
		 }
		 });
		 squirtle.lapse();
		 bulbasaur.lapse();
		 printScore(squirtle, bulbasaur);
		 System.out.println("Squirtle is attacking again");
		 
		 squirtle.attack(bulbasaur, new Attack() {
			
			
			public void attack(Pokemon target) {
				int hp = target.getHp();
				target.setHp(hp - 100);
			}
		});
		squirtle.levelUp(new Effect() {
			
			
			public void happen() {
				//code goes here
				//final if you want to modify a reference outside this body
				squirtle.setHp(100);
				
			}
		});
		 
		 
	}
	
	private static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName() + ": HP = " + p1.getHp());
		System.out.println(p2.getName() + ": HP = " + p2.getHp());
	}
}
