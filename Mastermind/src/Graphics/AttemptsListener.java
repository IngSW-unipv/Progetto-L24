package Graphics;   //Definisce il package in cui è contenuta l'interfaccia AttemptListener

public interface AttemptsListener {

//    Metodo "ponte" per il passaggio del nuovo numero di tentativi disponibili
    void difficultyChoose(int attempts);
}
