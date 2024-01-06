module FSM (
  input alu, st, ld, jump, cmpJump, cmpJumpEnable, clk, reset,
  output reg enableWrite,
  output reg enablePC,
  output reg enableJUMP,
  output reg enableCMPJUMP,
  output reg nextInstruction
);





  parameter INIT_STATE   = 'd 0;
  parameter ALU_STATE1 = 'd 1;
  parameter ALU_STATE2 = 'd 2;
  parameter LD_STATE1 = 'd 3;
  parameter LD_STATE2 = 'd 4;
  parameter ST_STATE = 'd 5;
  parameter JUMP_STATE = 'd 6;
  parameter CMPJUMP_STATE = 'd 7;

    

  // FSM durumları
   

  // FSM durumu ve sonraki durum
  reg [2:0] currentState, nextState;



  // FSM data register
  reg [0:0] dataRegister;

  // Durumları kontrol etmek için işlem fonksiyonu
  always @(posedge clk or posedge reset) begin
    if (reset) begin
      currentState <= INIT_STATE;
      dataRegister <= 1'b0;
    end else begin
      currentState <= nextState;
    end

    
  end


  always_comb begin
    case (currentState)
      INIT_STATE: begin
        enableWrite = 1'b0;
        enablePC = 1'b1;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b0;
        nextState = alu ? ALU_STATE1 : (ld ? LD_STATE1 : (st ? ST_STATE : (jump ? JUMP_STATE : (cmpJump ? CMPJUMP_STATE : INIT_STATE))));
      end

      ALU_STATE1: begin
        enableWrite = 1'b1;
        enablePC = 1'b0;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b0;
        nextState = ALU_STATE2;
      end

      ALU_STATE2: begin
        enableWrite = 1'b0;
        enablePC = 1'b1;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b1;
        nextState = INIT_STATE;
      end

      LD_STATE1: begin
        enableWrite = 1'b1;
        enablePC = 1'b0;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b0;
        nextState = LD_STATE2;
      end

      LD_STATE2: begin
        enableWrite = 1'b0;
        enablePC = 1'b1;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b1;
        nextState = INIT_STATE;
      end

      ST_STATE: begin
        enableWrite = 1'b0;
        enablePC = 1'b1;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b1;
        nextState = INIT_STATE;
      end

      JUMP_STATE: begin
        enableWrite = 1'b0;
        enablePC = jump;
        enableJUMP = jump;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b0;
        nextState = INIT_STATE;
      end

      CMPJUMP_STATE: begin
        enableWrite = 1'b0;
        enablePC = cmpJump;
        enableJUMP = 1'b0;
        enableCMPJUMP = cmpJumpEnable;
        nextInstruction = !cmpJumpEnable;
        nextState = INIT_STATE;
      end

      default: begin
        enableWrite = 1'b0;
        enablePC = 1'b0;
        enableJUMP = 1'b0;
        enableCMPJUMP = 1'b0;
        nextInstruction = 1'b0;
        nextState = INIT_STATE;
      end
    endcase
  end

endmodule