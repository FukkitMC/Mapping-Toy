package net.devtech.foss.builddata;

import com.google.gson.Gson;
import net.devtech.foss.util.FuncUtil;
import net.devtech.foss.util.IOUtil;
import net.devtech.foss.util.func.BooleanOperator;
import net.fabricmc.mappings.ClassEntry;
import net.fabricmc.mappings.FieldEntry;
import net.fabricmc.mappings.Mappings;
import net.fabricmc.mappings.MethodEntry;
import org.jetbrains.annotations.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BuildData implements Mappings {
	public static BuildData createBukkitToIntermediary(@Nullable String commit) throws IOException {
		String link;
		if (commit != null) link = "https://hub.spigotmc.org/stash/rest/api/latest/projects/SPIGOT/repos/builddata/archive?at=" + commit + "&format=zip";
		else link = "";
		URL url = new URL(link);
		ZipInputStream zip = new ZipInputStream(url.openStream());
		ZipEntry entry;
		Info info = null;
		Map<String, byte[]> data = new HashMap<>();
		while ((entry = zip.getNextEntry()) != null) {
			String name = entry.getName();
			if(name.startsWith("mappings/")) {
				// possible
				String truePath = name.substring("mappings/".length()+1);
				if(info == null)
					data.put(name, IOUtil.read(zip));
				else { // test immediate eval

				}
			} else if(name.startsWith("info.json")) {
				// json
				Gson gson = new Gson();
				info = gson.fromJson(new InputStreamReader(zip), Info.class);
			}
			zip.closeEntry();
		}
	}

	private final List<ClassEntry> classEntries = new ArrayList<>();
	private final File serverJar;

	public BuildData(Map<String, String> classMap, File jar) {
		this.serverJar = jar;
		classMap.forEach((from, to) -> this.classEntries.add(a -> {
			if(a.equals("official"))
				return from;
			else if(a.equals("bukkit"))
				return to;
			else
				throw new UnsupportedOperationException(a + " not supported!");
		}));
	}


	@Override
	public Collection<String> getNamespaces() {
		return Arrays.asList("official", "bukkit");
	}

	@Override
	public Collection<ClassEntry> getClassEntries() {
		return this.classEntries;
	}

	@Override
	public Collection<FieldEntry> getFieldEntries() {
		return null;
	}

	@Override
	public Collection<MethodEntry> getMethodEntries() {
		return null;
	}
}
