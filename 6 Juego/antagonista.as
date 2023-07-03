package  {
	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.utils.Timer;
	import flash.events.TimerEvent;
	
	public class antagonista extends MovieClip {
		
	    private var limite_der: int = 520;
		private var limite_izq: int = 32;
		private var dir: Number = 1;
		private var vel: int = 10;
		private var cambia: Timer = new Timer(200,0);
		private var tipo: Number;
		private var lanzar: Timer= new Timer(750,0);


		public function antagonista() {
			
			addEventListener(Event.ENTER_FRAME, actualiza);
			cambia.addEventListener(TimerEvent.TIMER, cambia_dir);
			cambia.start();
			lanzar.addEventListener(TimerEvent.TIMER, lanza_bala);
			lanzar.start();
		}
		
		public function cambia_dir(e:TimerEvent){
			tipo=Math.floor(Math.random() * 8);
			switch(tipo){
				case 1: dir=1;
				break;
				case 2: dir=1;
				break;
			}
		}
		
		public function actualiza(e:Event){
			
			x+= vel*dir;
			if ( x >= limite_der){
				dir = -1;
				
			}
			if (x<=limite_izq){
				dir = 1;
			}
			if (setup.puntos>0 && setup.puntos%5==0){
				vel+=1;
				}
			
		}
				public function lanza_bala(e:TimerEvent){
					//trace("Lanza bala");
					var bala_nueva= new bala(x,y);
					stage.addChild(bala_nueva);
					}
	}
	
}
