/**
 * 
 */

import cn.richinfo.cmail.common.tools.LicenseDES;

/**
 * @author Administrator
 *
 */
public class LicCrype_Java_DES_Impl implements LicCrypt {
	
	private static final String key = "destkey";

	/* 解密
	 * @see cn.richinfo.cmail.licensetools.common.LicCrypt#decrypt(byte[])
	 */
	@Override
	public byte[] decrypt(byte[] lic) {
		return LicenseDES.DES_Decrypt(key.getBytes(), lic);
	}

	/* 加密
	 * @see cn.richinfo.cmail.licensetools.common.LicCrypt#encrypt(byte[])
	 */
	@Override
	public byte[] encrypt(byte[] lic) {
		return LicenseDES.DES_Encrypt(key.getBytes(), lic);
	}

}
