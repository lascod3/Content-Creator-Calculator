
public class Content {
	public static long followers;
	public static int numberOfPost;
	public static double engagement;
	public static String niche;
	public static String influencers;
	public static String platform;
	private double price;
	
	public Content() {

	}
	public Content(long followers, double engagement, int numberOfPost, String niche, String platform) {
		Content.followers = followers;
		Content.engagement = engagement;
		Content.numberOfPost = numberOfPost;
		Content.niche = niche;
		Content.platform = platform;
		// influencers = "Testing ";
		price = 0;
	}
	public long getFollowers() {
		return followers;
	}
	
	public double getEngagment() {
		return engagement;
	}
	
	public String getIndustry() {
		return niche;
	}
	
	public String getPlatform() {
		return platform ;
	}

	public int getNoPost() {
		return numberOfPost ;
	}
	
	public String getInfluencers() {
		return influencers ;
	}
	
	public void caluator(String platform) {
		this.platform =platform;
		switch(platform) {
			case "Facebook": facebook();
			break;
			case "Instagram": instagram();
			break;
			case "Tiktok": tiktok();
			break;
			case "YouTube": youtube();
			break;
			default: System.out.println("No such Platform");
		}
	}
	
	public void facebook(){
		System.out.println("This is FaceBook");
		
		influencers = checks();
		
		influencers = getInfluencers();
//		System.out.println(influencers);
	}

	public void instagram(){
		System.out.println("This is Instagram");
	}
	public void tiktok(){
		System.out.println("This is Tiktok");
	}
	public void youtube(){
		System.out.println("This is Youtube");
	}



	public String checks(){
		
	if(followers>=1000 && followers<10000) {
			influencers = "Nano-influencer: 1,000–10,000 followers";
		}
		else if(followers>10000 && followers<50000){
			influencers = "Micro-influencer: 10,000–50,000 followers";
		}
		else if(followers>50000 && followers<500000){
			influencers = "Mid-tier influencer: 50,000–500,000 followers";
		}
		else if(followers>500000 && followers<1000000){
			influencers = "Macro-influencer: 500,000–1,000,000 followers";
		}
		else if(followers>1000000){
			influencers = "Mega-influencer: 1,000,000+ followers";
		}
		else {
			influencers = "Your Account is not quite profitable";
		}
	return influencers;
	}
	
	public String toString() {
		return "Follower: " +followers + "\nEngagement: " + engagement+ "\nPost: "+numberOfPost + "Niche: " +niche+ "\nPlatform"+ platform;
	}
	
}
