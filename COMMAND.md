# Getting Started

## User Flow

### Code Build command

- Set Project id, Project zone

```
gcloud config set project happy-427410
gcloud config set compute/zone asia-east1
```

- Submit build

```
gcloud builds submit --region asia-east1
```

- Deploy

```
gcloud run deploy  
```
