public class Tarefa {
    public int id;
    public String titulo;
    public boolean concluida;

    public Tarefa(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = false;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    public void desmarcarConcluida() {
        this.concluida = false;
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + id + " - " + titulo;
    }
}
