package com.mycompany.passwordLogic;

public class PasswordLogic {

	/**
	 * Takes in a message (comprised of alphanumeric charactesr and spaces)
	 * and cuts it off at the length of value K with the
	 * following conditions: 
	 * -- must crop full words 
	 * -- message cannot end with space 
	 * -- message may not exceed k limit 
	 * -- message must be as long as possible
	 * 
	 * @param message {String}  Message to crop
	 * @param K {int} value denoting 
	 * @return {String} full message
	 */
	public String calculateValidMessage(String message, int K) {
		boolean isLastWordCut;

		String retVal = "";
		// validation methods
		if (message == null) {
			return message;
		}

		if (K == 0) {
			return "";
		}

		if (message.length() <= K) {
			return message;
		}

		String cutMessage = message.substring(0, K);
		isLastWordCut = determineIfLastWordWillBeCut(message, K);
		// split on whitespace
		String[] splitCutMessage = cutMessage.split("\\s+");

		for (int i = 0; i < splitCutMessage.length; i++) {
			// check if element is last word in the message
			if (i == splitCutMessage.length) {
				if (isLastWordCut) {
					break;
				}
				if (retVal.length() + splitCutMessage[i].length() < K) {
					retVal = retVal + splitCutMessage[i];
				}
			} else { // if it isn't, check if the next word fits
				if (retVal.length() + splitCutMessage[i].length() <= K) {
					retVal = retVal + splitCutMessage[i] + " ";
				}
			}
		}
		System.out.println(retVal.trim());
		return retVal.trim();
	}

	/**
	 * Determines if the last word in the substring was complete or was cut
	 * @param message
	 * @param K
	 * @return
	 */
	private boolean determineIfLastWordWillBeCut(String message, int K) {
		if (message.charAt(K++) != ' ') {
			return true;
		}
		return false;
	}
}