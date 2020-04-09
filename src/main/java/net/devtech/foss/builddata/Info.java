package net.devtech.foss.builddata;

public class Info {
	private final String minecraftVersion;
	private final String serverUrl;
	private final String minecraftHash;
	private final String accessTransforms;
	private final String classMappings;
	private final String memberMappings;
	private final String packageMappings;
	private final String classMapCommand;
	private final String memberMapCommand;
	private final String finalMapCommand;
	private final String decompileCommand;
	private final int toolsVersion;

	public Info(String minecraftVersion, String serverUrl, String minecraftHash, String accessTransforms, String classMappings, String memberMappings, String packageMappings, String classMapCommand, String memberMapCommand, String finalMapCommand,
	            String decompileCommand, int version) {
		this.minecraftVersion = minecraftVersion;
		this.serverUrl = serverUrl;
		this.minecraftHash = minecraftHash;
		this.accessTransforms = accessTransforms;
		this.classMappings = classMappings;
		this.memberMappings = memberMappings;
		this.packageMappings = packageMappings;
		this.classMapCommand = classMapCommand;
		this.memberMapCommand = memberMapCommand;
		this.finalMapCommand = finalMapCommand;
		this.decompileCommand = decompileCommand;
		this.toolsVersion = version;
	}

	public String getMinecraftVersion() {
		return this.minecraftVersion;
	}

	public String getServerUrl() {
		return this.serverUrl;
	}

	public String getMinecraftHash() {
		return this.minecraftHash;
	}

	public String getAccessTransforms() {
		return this.accessTransforms;
	}

	public String getClassMappings() {
		return this.classMappings;
	}

	public String getMemberMappings() {
		return this.memberMappings;
	}

	public String getPackageMappings() {
		return this.packageMappings;
	}

	public String getClassMapCommand() {
		return this.classMapCommand;
	}

	public String getMemberMapCommand() {
		return this.memberMapCommand;
	}

	public String getFinalMapCommand() {
		return this.finalMapCommand;
	}

	public String getDecompileCommand() {
		return this.decompileCommand;
	}

	public int getToolsVersion() {
		return this.toolsVersion;
	}
}
