package com.bage.utils;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {

	public static String compactJws(String sub,SignatureAlgorithm alg, Key key) {
		return Jwts.builder()
		  .setSubject(sub)
		  .signWith(alg, key)
		  .compact();
		
	}

	public static String compactJws(String sub,Key key) {
		return compactJws(sub,SignatureAlgorithm.HS512,key);
		
	}

	public static Jws<Claims> parse(String claimsJws,Key key) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(claimsJws);
		
	}
	

	
}
