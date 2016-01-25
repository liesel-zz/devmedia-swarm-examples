package br.com.devmedia;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.WARArchive;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
			Container container = new Container();
			System.out.println( "Swarm no ar" );
			container.start();
			WARArchive deployment = ShrinkWrap.create(WARArchive.class);
			deployment.addClass(Welcome.class);

	        deployment.addAsWebResource(
	                new ClassLoaderAsset("index.html", App.class.getClassLoader()), "index.html");
	        deployment.addAsWebResource(
	                new ClassLoaderAsset("index.xhtml", App.class.getClassLoader()), "index.xhtml");

	        deployment.addAsWebInfResource(
	                new ClassLoaderAsset("WEB-INF/web.xml", App.class.getClassLoader()), "web.xml");
	        deployment.addAsWebInfResource(
	                new ClassLoaderAsset("WEB-INF/template.xhtml", App.class.getClassLoader()), "template.xhtml");

	        deployment.addAllDependencies();
			deployment.addClass(HelloSwarm.class);
			container.deploy(deployment);	
		        
    }
}
