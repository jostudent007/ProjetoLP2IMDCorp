package dao;

import entities.Pessoa;
import java.io.*;
import java.util.ArrayList;

public class BancoDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static BancoDAO instance;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Pessoa> funcionarios;

    // Caminho do arquivo para salvar os dados
    private static final String FILE_PATH = "funcionarios.bin";

    private BancoDAO() {
        // Inicializa a lista de funcionários
        this.funcionarios = new ArrayList<>();
        carregarDados();
    }

    public static BancoDAO getInstance() {
        if (instance == null) {
            instance = carregarDados(); // Tenta carregar os dados do arquivo
            if (instance == null) {
                instance = new BancoDAO(); // Cria uma nova instância se o arquivo não existir
            }
        }
        return instance;
    }

    public ArrayList<Pessoa> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarFuncionario(Pessoa pessoa) {
        this.funcionarios.add(pessoa);
    }

    public void removerFuncionario(Pessoa pessoa) {
        this.funcionarios.remove(pessoa);
    }

    // Método para salvar os dados no arquivo
    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(instance);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Método para carregar os dados do arquivo
    private static BancoDAO carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (BancoDAO) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo banco de dados.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return null;
    }
    
}
