package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate nand0In;
    private final NandGate nand1In;
    private final NandGate nand2In;
    private final NandGate nandOut;

    //construtor
        nand0In = new NandGate();
        nand1In = new NandGate();
        nand2In = new NandGate();
        nandOut = new NandGate();

        nandOut.connect(0, nand2In);
        nandOut.connect(1, nand2In);
    }

    //vou retornar o valor de nandOut definido no construtor
    @Override
    public boolean read() {
        return nandOut.read();
    }


    // switch--> cada case pega o valor que está sendo passado no switch e compara
    // com cada um dos casos que estão em sua estrutura
    //The switch expression is evaluated once.
    //The value of the expression is compared with the values of each case.
    //If there is a match, the associated block of code is executed.
    //If there is no match, the default code block is executed.
    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0: //caso o index seja 0
                nand0In.connect(0, emitter);
                nand0In.connect(1, emitter);
                nand1In.connect(0, nand0In);
                nand1In.connect(1, nand0In);
                break;
            case 1: //caso o index seja 1
                nand2In.connect(0, nand1In);
                nand2In.connect(1, emitter);
                break;
            default:
                //se nao for nenhum nem outro ta fora do range
                throw new IndexOutOfBoundsException(inputIndex);
        }
    }
}
