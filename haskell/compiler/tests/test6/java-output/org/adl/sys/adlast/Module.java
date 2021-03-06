/* Code generated from adl module sys.adlast */

package org.adl.sys.adlast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.adl.runtime.Factories;
import org.adl.runtime.Factory;
import org.adl.runtime.HashMapHelpers;
import org.adl.runtime.JsonBinding;
import org.adl.runtime.JsonBindings;
import org.adl.runtime.Lazy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Module {

  /* Members */

  private String name;
  private ArrayList<Import> imports;
  private HashMap<String, Decl> decls;

  /* Constructors */

  public Module(String name, ArrayList<Import> imports, HashMap<String, Decl> decls) {
    this.name = Objects.requireNonNull(name);
    this.imports = Objects.requireNonNull(imports);
    this.decls = Objects.requireNonNull(decls);
  }

  public Module() {
    this.name = "";
    this.imports = new ArrayList<Import>();
    this.decls = HashMapHelpers.factory(Factories.STRING, Decl.FACTORY).create();
  }

  public Module(Module other) {
    this.name = other.name;
    this.imports = Factories.arrayList(Import.FACTORY).create(other.imports);
    this.decls = HashMapHelpers.factory(Factories.STRING, Decl.FACTORY).create(other.decls);
  }

  /* Accessors and mutators */

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name);
  }

  public ArrayList<Import> getImports() {
    return imports;
  }

  public void setImports(ArrayList<Import> imports) {
    this.imports = Objects.requireNonNull(imports);
  }

  public HashMap<String, Decl> getDecls() {
    return decls;
  }

  public void setDecls(HashMap<String, Decl> decls) {
    this.decls = Objects.requireNonNull(decls);
  }

  /* Object level helpers */

  @Override
  public boolean equals(Object other0) {
    if (!(other0 instanceof Module)) {
      return false;
    }
    Module other = (Module) other0;
    return
      name.equals(other.name) &&
      imports.equals(other.imports) &&
      decls.equals(other.decls);
  }

  @Override
  public int hashCode() {
    int _result = 1;
    _result = _result * 37 + name.hashCode();
    _result = _result * 37 + imports.hashCode();
    _result = _result * 37 + decls.hashCode();
    return _result;
  }

  /* Factory for construction of generic values */

  public static final Factory<Module> FACTORY = new Factory<Module>() {
    public Module create() {
      return new Module();
    }
    public Module create(Module other) {
      return new Module(other);
    }
  };

  /* Json serialization */

  public static JsonBinding<Module> jsonBinding() {
    final Lazy<JsonBinding<String>> name = new Lazy<>(() -> JsonBindings.STRING);
    final Lazy<JsonBinding<ArrayList<Import>>> imports = new Lazy<>(() -> JsonBindings.arrayList(Import.jsonBinding()));
    final Lazy<JsonBinding<HashMap<String, Decl>>> decls = new Lazy<>(() -> HashMapHelpers.jsonBinding(JsonBindings.STRING, Decl.jsonBinding()));
    final Factory<Module> _factory = FACTORY;

    return new JsonBinding<Module>() {
      public Factory<Module> factory() {
        return _factory;
      }

      public JsonElement toJson(Module _value) {
        JsonObject _result = new JsonObject();
        _result.add("name", name.get().toJson(_value.name));
        _result.add("imports", imports.get().toJson(_value.imports));
        _result.add("decls", decls.get().toJson(_value.decls));
        return _result;
      }

      public Module fromJson(JsonElement _json) {
        JsonObject _obj = JsonBindings.objectFromJson(_json);
        return new Module(
          JsonBindings.fieldFromJson(_obj, "name", name.get()),
          JsonBindings.fieldFromJson(_obj, "imports", imports.get()),
          JsonBindings.fieldFromJson(_obj, "decls", decls.get())
        );
      }
    };
  }
}
