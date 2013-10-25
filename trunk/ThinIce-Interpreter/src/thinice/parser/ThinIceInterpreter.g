//------------------------------------------------------------------------------------------------------------------
programa -> 		PROGRAM PAR_I PAR_D LLA_I lista_sent LLA_D
//--------------------------------------
lista_sent ->		lista_sent sent	|	sent
//--------------------------------------
sent ->				sent_decl PUNT_C
				|	sent_asig PUNT_C
				|	func_call PUNT_C
				|	sent_if
				|	sent_do
				|	sent_for
//------------------------------------------------------------------------------------------------------------------
sent_decl ->		tipo_var variable
				|	tipo_var sent_asig
tipo_var ->			INT	|	BOOL
//--------------------------------------
sent_asig ->		variable ASIG exp
//--------------------------------------
func_call ->		ID PAR_I lista_parm PAR_D
lista_parm ->		lista_parm COMA exp	|	exp
//--------------------------------------
sent_if ->			IF PAR_I exp PAR_D LLA_I lista_sent LLA_D else
else ->				ELSE LLA_I lista_sent LLA_D	|	EMPTY
//--------------------------------------
sent_do ->			DO lista_sent WHILE PAR_I exp PAR_D
//--------------------------------------
sent_for ->			FOR PAR_I sent_asig PUNT_C sent_asig PUNT_C exp PAR_D LLA_I lista_sent LLA_D
//------------------------------------------------------------------------------------------------------------------
exp -> 				exp_booleana AND exp_booleana
				|	exp_booleana OR exp_booleana
				|	NOT exp
				|	exp_booleana
//--------------------------------------
exp_booleana -> 	exp_booleana op_comparacion exp_aritmetica
				|	exp_aritmetica
op_comparacion ->	MENOR	|	MENOR_IGUAL	|	MAYOR_IGUAL	|	MAYOR	|	IGUAL	|	DIFERENTE
//--------------------------------------
exp_aritmetica ->	exp_aritmetica op_aritmetica exp_factor
				|	exp_factor
op_aritmetica ->	SUMA	|	RESTA
//--------------------------------------
exp_factor ->		exp_factor op_factor termino
				|	termino
op_factor ->		MULTI	|	DIV	|	MOD
//--------------------------------------
termino ->			PAR_I exp PAR_D
				|	func_call
				|	literal
				|	variable
//--------------------------------------
literal ->			ENTERO
				|	BOOLEANO
//--------------------------------------
variable ->			ID
				|	vector
//--------------------------------------
vector ->			ID COR_I exp COR_D
//------------------------------------------------------------------------------------------------------------------