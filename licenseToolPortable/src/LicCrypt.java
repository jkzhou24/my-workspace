public interface LicCrypt {
	
	/**
	 * 解密license
	 * @param lic
	 * @return
	 */
	public byte[] decrypt(byte[] lic);
	
	/**
	 * 加密license
	 * @param lic
	 * @return
	 */
	public byte[] encrypt(byte[] lic);

}
