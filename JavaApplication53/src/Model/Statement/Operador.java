package Model.Statement;

public class Operador extends Statement
{
    private int EspacosOperadorVariavel, EspacosVariavelOperador;
    
    public Operador(String Statement)
    {
//        this.Statement=Statement;
    }

    public int getEspacosOperadorVariavel()
    {
        return EspacosOperadorVariavel;
    }

    public void setEspacosOperadorVariavel(int EspacosOperadorVariavel)
    {
        this.EspacosOperadorVariavel = EspacosOperadorVariavel;
    }

    public int getEspacosVariavelOperador()
    {
        return EspacosVariavelOperador;
    }

    public void setEspacosVariavelOperador(int EspacosVariavelOperador)
    {
        this.EspacosVariavelOperador = EspacosVariavelOperador;
    }
    
    @Override
    public void analisaStatement()
    {
//        EspacosOperadorVariavel=0;
//        EspacosVariavelOperador=0;
//        int i=0;
//        char c;
//        
//        for(i=0;i<Statement.length();i++)
//        {
//            try
//            {
//                    int posicaoOperador=i;
//                    if(Statement.charAt(i+1)=='+' || Statement.charAt(i+1)=='-')
//                        i++;
//                    
//                    while(Statement.charAt(++i)==' ')
//                        EspacosOperadorVariavel++;
//
//                    while(Statement.charAt(--posicaoOperador)==' ')
//                        EspacosVariavelOperador++;
//
//                    break;
//            }
//            catch(Exception e)
//            {
//                
//            }
//        }
    }
    
    @Override
    public void converteStatement()
    {
        
    }
}
