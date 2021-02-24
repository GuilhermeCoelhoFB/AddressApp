package br.cefetmg.address.view;
import br.cefetmg.address.controller.PersonHandler;
import br.cefetmg.address.model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PersonView {
    
//responsável pela visualização dos textos em personHandler    
    Scanner in = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    PersonHandler pf = new PersonHandler();
    private String firstName;
    private String lastName;
    private String street;
    private Integer postalCode;
    private String city;
    
    
    public void menu(){
        int x=-1;
        while(x!=0){
            System.out.print("O que deseja fazer?\n0:Sair\n1:Inserir Pessoa\n2:Atualizar Pessoa\n"
                    + "3:Deletar Pessoa\n4:Encontrar pessoa por ID\n5:Listar todas as pessoas\n");
            x = in.nextInt(); in.nextLine();
            switch(x){
                case 0: break;
                case 1: insereTxt();
                break;
                case 2: atualizaTxt();
                break;
                case 3: deletarTxt();
                break;
                case 4: encontrarTxt();
                break;
                case 5: listarTxt();
                break;
            }
        }
    }
    
    public void insereTxt(){
        System.out.print("Insira o primeiro nome da pessoa a ser inserida: ");
        firstName = in.nextLine(); 
        
        System.out.print("Insira o último nome da pessoa a ser inserida: ");
        lastName = in.nextLine();
        
        System.out.print("Insira a rua e o número da casa da pessoa a ser inserida: ");
        street = in.nextLine();
        
        System.out.print("Insira o código postal da pessoa a ser inserida: ");
        postalCode = in.nextInt();
        
        System.out.print("Insira a cidade da pessoa a ser inserida: ");
        in.nextLine();
        city = in.nextLine();
               
        System.out.print("Insira a data de nascimento da pessoa a ser inserida no formato dd/mm/yyyy: ");
        String dataString = in.nextLine();
        
        LocalDate data = LocalDate.parse(dataString,formatter);
        
        pf.inserir(firstName, lastName, street, postalCode, city, data);
    }
  
    public void atualizaTxt(){
        System.out.print("Insira o ID da pessoa a ser alterada: ");
        Long id = in.nextLong();  in.nextLine();

        
        if(pf.verificaPessoa(id)){
        
        
        System.out.print("Insira o primeiro nome da pessoa a ser atualizada: ");
            firstName = in.nextLine(); 

            System.out.print("Insira o último nome da pessoa a ser atualizada: ");
            lastName = in.nextLine();


            System.out.print("Insira a rua e o número da casa da pessoa a ser atualizada: ");
            street = in.nextLine();

            System.out.print("Insira o código postal da pessoa a ser atualizada: ");
            postalCode = in.nextInt();

            System.out.print("Insira a cidade da pessoa a ser atualizada: ");
            in.nextLine();
            city = in.nextLine();

            System.out.print("Insira a data de nascimento da pessoa a ser atualizada no formato dd/mm/yyyy: ");
            String dataString = in.nextLine();
            LocalDate data = LocalDate.parse(dataString,formatter);
            pf.atualizar(id, firstName, lastName, firstName, postalCode, city, data);
        }
        else System.out.println("ID inválido (tenis da nike ta caro)");
    }
    
    public void deletarTxt(){
        System.out.print("Insira o ID da pessoa a ser deletada: ");
        Long id = in.nextLong();
        if(pf.verificaPessoa(id)){
            Person denis = pf.deletar(id); 
            System.out.println("Nome:" + denis.getFirstName() +  " " + denis.getLastName()+ "\n rua: " + denis.getStreet() +
                                "\n CEP: " + denis.getPostalCode()+ "\n cidade:  "+ denis.getCity()+ "\n nascimento: " + denis.getBirthday() /*denis da nike ta caro*/ );
        }
        else System.out.println("ID inválido") /*tenis da nike ta caro*/;
    }
    
    public void encontrarTxt(){
        System.out.print("Insira o ID da pessoa a ser encontrada: ");
        Long id = in.nextLong();
        if(pf.verificaPessoa(id)){
            Person encontrado = pf.encontrar(id);
            System.out.println(encontrado.getId()+"-> "+encontrado.getFirstName() +
                    " " + encontrado.getLastName() + "\nEndereço: " + encontrado.getStreet() +
                    "\nCódigo postal: " + encontrado.getPostalCode() + "\nCidade:" + encontrado.getCity() + "\nNascimento: "
                    + encontrado.getBirthday() + "\n");
        }
        else System.out.println("Erro, pessoa ou id inexistentes");
    }
    
    public void listarTxt(){
        List<Person> lista = pf.listar();
        System.out.println("Lista de pessoas:");
            for (Person p: lista)
                System.out.println(p.getId()+"-> "+p.getFirstName() + " " + p.getLastName());
            System.out.println();
    }
}

        
