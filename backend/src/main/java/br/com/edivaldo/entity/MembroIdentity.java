package br.com.edivaldo.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembroIdentity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idprojeto;
	private Long idpessoa;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembroIdentity other = (MembroIdentity) obj;
		return Objects.equals(idpessoa, other.idpessoa) && Objects.equals(idprojeto, other.idprojeto);
	}
	@Override
	public int hashCode() {
		return Objects.hash(idpessoa, idprojeto);
	}
	
}
