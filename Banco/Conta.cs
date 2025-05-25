using System;
using System.Collections.Generic;
using System.Text;

namespace Projeto PM 01-2025.Banco
{
	public abstract class Conta
	{
		int id;
		double saldo;
		Cliente cliente;
		Transacao transacoes;

		public void sacar(double valor)
		{
			
		}

		public void depositar(double valor)
		{
			
		}

		public double calcularRendimento()
		{
			
		}

		public void getExtrato()
		{
			
		}
	}
}
