package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	@Qualifier("internacional")
	private MontoDebitarService debitarService;

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionarNumero(numero);
	}

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub

		// 1. Consultar la cuenta de origen por el num.
		Cuenta ctaOrigen = this.cuentaRepository.seleccionarNumero(numeroCtaOrigen);

		// 2. Consultar el saldo de la cuenta origen.
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		
		BigDecimal montoDebitar = this.debitarService.calcular(monto);
		
		
		System.out.println("Saldo destino antes  " + saldoOrigen);
		// 3. Validar si el saldo es suuuuficiente
		if (montoDebitar.compareTo(saldoOrigen) <= 0) {

			// 5. Si, si es suficiente, ir al paso 6.
			// 6. Realizamos la resta de la cuenta origen (saldo origen - monto)
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(montoDebitar);
			
			// 7. Actualizamos el saldo de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);

			// 8. Consultamos la cuenta de destino por el num.
			Cuenta ctaDestino = this.cuentaRepository.seleccionarNumero(numeroCtaDestino);
			// 9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			
			// 10. Realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);

			// 11. Actualizamos el nuevo saldo de la cta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaRepository.actualizar(ctaDestino);
			
			// 12. Creamos la transferencia
			Transferencia trans = new Transferencia();
			
			trans.setCuentaDestino(ctaDestino);
			trans.setCuentaOrigen(ctaOrigen);
			trans.setFecha(LocalDateTime.now());
			trans.setMonto(monto);
			
			Double num = Math.random();
			
			trans.setNumero(num.toString());
			
			this.transferenciaRepository.insertar(trans);

		} else {
			// 4. Si no es suficiente imprimir mensaje de "no saldo"

			System.out.println("Saldo no diponible, su saldo es: " + saldoOrigen);
		}

	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.buscarTodos();
	}

}
