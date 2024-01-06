`timescale 1ns / 1ps

module RegisterFile_tb;

  reg [3:0] read_addr1, read_addr2, write_addr;
  reg [17:0] write_data, write_data_in;
  reg write_enable, clk;

  wire [17:0] data_out1, data_out2;

  // RegisterFile modülünü çağırma
  RegisterFile uut (
    .read_addr1(read_addr1),
    .read_addr2(read_addr2),
    .write_addr(write_addr),
    .write_data(write_data),
    .write_data_in(write_data_in),
    .write_enable(write_enable),
    .clk(clk),
    .data_out1(data_out1),
    .data_out2(data_out2)
  );

  // Clock sinyali üretme
  initial begin
    clk = 0;
    forever #5 clk = ~clk;
  end

  // Test senaryosu
  initial begin
    // Test başlangıcı
    $display("Test başladı...");

    // Write Enable etkinleştirilir
    write_enable = 1;

    // Write Addr = 3, Write Data = 18'd0A5
    write_addr = 3;
    write_data = 18'd42;
    #10;

    // Read Addr 1 = 3, Read Addr 2 = 2
    read_addr1 = 3;
    read_addr2 = 2;
    #10;

    // Write Addr = 1, Write Data = 18'd42
    write_addr = 1;
    write_data = 18'hA5;
    #10;

    // Read Addr 1 = 1, Read Addr 2 = 0
    read_addr1 = 1;
    read_addr2 = 0;
    #10;

    // Write Enable devre dışı bırakılır
    write_enable = 0;
    #10;

    // Test tamamlandı
    $display("Test tamamlandı.");
    $finish;
  end

endmodule